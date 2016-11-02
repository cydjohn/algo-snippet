select Round(sum(TIV_2012), 2)
from Insurance
where Insurance.PID in (
        select PID
        from Insurance i1, Insurance i2
        where i1.TIV_2011 == i2.TIV_2011 and i1.PID != i2.PID. from
) and Insurance.PID  not in (
        select i1.PID
        from Insurance i1, Insurance i2
        where i1.LAT = i2.LAT and i1.LON = i2.LON and i1.PID != i2.PID
)


select xy as 学院, count(*) as 总人数 from xs group by xy;
select * 
from Students right join Departments
on Students.DEPT_ID == Departments.DEPT_ID



select DEPT_NAME as [department name], count(*) as [number of students] 
from (
	select * 
	from Students right join Departments
	on Students.DEPT_ID == Departments.DEPT_ID
)
group by [department name]
order by [number of students] desc;

select DEPT_NAME as "department name", count(*) as "number of students" FROM (select * FROM Students right join Departments on Students.DEPT_ID == Departments.DEPT_ID) group by "department name" order by "number of students" desc;

select DEPT_NAME as "department name", CNT as "number of students"
from Departments left join (
	select DEPT_ID as DEPT_ID, count(*) as CNT 
	into Students_CNT
	from Students 
	group by DEPT_ID;
)
on Students_CNT.DEPT_ID == Departments.DEPT_ID;


select Departments.DEPT_NAME as "department name", sum(case when Students.DEPT_ID = Departments.DEPT_ID then 1 else 0 end) as "number of students" from Departments left join Students on Students.DEPT_ID = Departments.DEPT_ID group by DEPT_NAME order by "number of students" desc;






