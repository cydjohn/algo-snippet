class GridIllumination:
        def checkIllumination(N, lamps, queries):
                row = {}
                col = {}
                dia = {}
                rdia = {}
                S = []

                for lamp in lamps:
                        S.append(lamp)
                        x = lamp[0]
                        y = lamp[1]
                        row[x] = row.get(x, 0) + 1
                        col[y] = col.get(y, 0) + 1
                        dia[x-y] = dia.get(x-y, 0) + 1
                        rdia[x+y] = rdia.get(x+y, 0) + 1
                ret = list()
                for query in queries:
                        x = query[0]
                        y = query[1]

                        xs = [x-1, x, x+1]
                        ys = [y-1, y, y+1]

                        for i in xs:
                                if i>0 and i <= N:
                                        for j in ys:
                                                if j>0 and j <= N and (i, j) in S:
                                                        row[i] -= 1
                                                        col[j] -= 1
                                                        dia[i-j] -= 1
                                                        rdia[i+j] -= 1
                        dark = isDark(x, row) and isDark(y, col) and isDark(x-y, dia) and isDark(x+y, rdia)
                        if dark: 
                                ret.append("DARK")
                        else: 
                                ret.append("LIGHT")

                        ## turn on the light
                        for i in xs:
                                if i>0 and i <= N:
                                        for j in ys:
                                                if j>0 and j <= N and (i, j) in S:
                                                        row[i] += 1
                                                        col[j] += 1
                                                        dia[i-j] += 1
                                                        rdia[i+j] += 1
                return ret                        
                
        def isDark(i, map):
                if i in map:
                        if map.get(i, 0) > 0: return False
                return True

if __name__ == "__main__":
        grid = GridIllumination()
        ret = grid.checkIllumination(8, [(4, 3), (4, 4)], [(3, 4), (7, 6)])
        print ret