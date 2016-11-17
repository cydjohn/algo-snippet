using System;
using System.Collections;
using System.Threading;

namespace ThreadSafeCirqularQueue
{
    class CirqularQueue
    {
        private byte[] queue = null;
        private uint size = 0;
        private int head;
        private int tail;
        private static object criticalSection = new object();
        private Semaphore writeLock;

        public CirqularQueue(uint queueSize)
        {
            size = queueSize;
            queue = new byte[size];
            head = tail = -1;
            writeLock = new Semaphore(1, 1);
        }

        public void Write(byte[] array)
        {
            bool validWrite = true;

            lock(criticalSection)
            {
                writeLock.WaitOne();
                if (head == -1 && tail == -1 && array.Length > size)
                {
                    Console.WriteLine("ERROR: Queue size is too small");
                    validWrite = false;
                }
                else
                {
                    if (head > tail && head - tail - 1 < array.Length ||
                        head < tail && size - (tail - head + 1) < array.Length)
                    {
                        Console.WriteLine("ERROR: Queue is full");
                        lock(criticalSection)
                        {
                            validWrite = false;
                        }
                    }
                }
                writeLock.Release();

                if (validWrite == true)
                {
                    writeLock.WaitOne();
                    for (int i = 0; i < array.Length; i++)
                    {
                        if (head == -1)
                        {
                            head = 0;
                        }

                        tail++;
                        if (tail == size)
                        {
                            tail = 0;
                        }
                        queue[tail] = array[i];
                    }
                    writeLock.Release();
                }
            }
        }

        public byte[] Read(uint N)
        {
            byte[] result = null;
            bool validRead = true;

            lock(criticalSection)
            {
                writeLock.WaitOne();
                if (head == -1 && tail == -1)
                {
                    Console.WriteLine("ERROR: Queue is empty");
                    validRead = false;
                }
                else
                {
                    if (tail > head && tail - head + 1 < N || tail < head && size - head + tail + 1 < N)
                    {
                        Console.WriteLine("ERROR: Byte count to read is bigger than number of bytes queue contains");
                        validRead = false;
                    }
                }
                writeLock.Release();

                if (validRead == true)
                {
                    writeLock.WaitOne();
                    result = new byte[N];
                    for (int i = 0; i < N; i++)
                    {
                        result[i] = queue[head];
                        head++;
                        if (head == size)
                        {
                            head = 0;
                        }
                    }

                    if (head == tail)
                    {
                        head = tail = -1;
                    }
                    writeLock.Release();
                }
            }

            return result;
        }
    }

    class ThreadSafeCirqularQueue
    {
        static CirqularQueue queue = new CirqularQueue(7);

        static void ReadThreadBig ()
        {
            byte[] array = null;

            while (true)
            {
                Thread.Sleep(750);
                array = queue.Read(4);
                if (array != null)
                {
                    Console.Write("Array:");
                    for (int i = 0; i < array.Length; i++)
                    {
                        Console.Write(" {0}", array[i].ToString());
                    }
                    Console.WriteLine();
                }
            }
        }

        static void ReadThreadSmall()
        {
            byte[] array = null;

            while (true)
            {
                Thread.Sleep(250);
                array = queue.Read(1);
                if (array != null)
                {
                    Console.Write("Array:");
                    for (int i = 0; i < array.Length; i++)
                    {
                        Console.Write(" {0}", array[i].ToString());
                    }
                    Console.WriteLine();
                }
            }
        }

        static void WriteThreadBig()
        {
            byte[] array = new byte[] { 8, 9, 10 };

            while (true)
            {
                Thread.Sleep(1000);
                queue.Write(array);
            }
        }

        static void WriteThreadSmall()
        {
            byte[] array = new byte[] { 11 };

            while (true)
            {
                Thread.Sleep(500);
                queue.Write(array);
            }
        }

        static void Main(string[] args)
        {
            byte[] array = { 1, 2, 3, 4, 5, 6, 7 };
            queue.Write(array);

            Thread readThreadSmall = new Thread(ReadThreadSmall);
            readThreadSmall.Start();

            Thread writeThreadBig = new Thread(WriteThreadBig);
            writeThreadBig.Start();

            Thread readThreadBig = new Thread(ReadThreadBig);
            readThreadBig.Start();

            Thread writeThreadSmall = new Thread(WriteThreadSmall);
            writeThreadSmall.Start();
        }
    }
}