import fileinput as fi
import math as m

fun=[0]*700000

def funcion_selfdesc():
    fun[0] = 1
    fun[1] = 2
    fun[2] = 4
    i = 1
    while fun[fun[i] - 1] <= 2000000000:
        j = fun[i]
        while j < fun[i + 1]:
            fun[j] = fun[j - 1] + i+1
            j+=1
        i+=1


if __name__ == "__main__":
    lines_i = fi.input()
    lines = [int(line.strip()) for line in lines_i]

    i=0
    funcion_selfdesc()
    while lines[i]!=0:
        for x in range(len(fun)):
            if fun[x]==lines[i]:
                print(x+1)
                break
            elif fun[x]>lines[i]:
                print(x)
                break
        i+=1