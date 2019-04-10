import fileinput

lines_input=fileinput.input()
lines=[]
for line in lines_input: 
    lines.append(line)

# Precalculamos la lista
res = [2,5,13]
for i in range(3,1000): 
    res.append(2*res[i-1]+res[i-2]+res[i-3])

# Imprimimos el resultado
for line in lines:
    print(""+str(res[int(line)-1]))