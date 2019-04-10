import fileinput

Q=[[[0 for i in range(19)]for j in range(19)] for k in range(19)]

def NPR():
    Q[1][1][1] = 1
    for n in range(2, 14):
        for p in range(1, 14):
            for r in range(1, 14): Q[n][p][r] = Q[n-1][p][r] * (n-2) + Q[n-1][p-1][r] + Q[n-1][p][r-1]
                

if __name__ == "__main__":
    # Precalculamos NPR y factoriales
    NPR()
    lines_input=fileinput.input()
    lines=[]
    for line in lines_input: lines.append(line.strip())
    i=0
    cases=int(lines[i])
    for line in lines[1:]:
        x=line.split()
        N = int(x[0])
        P = int(x[1])
        R = int(x[2])
        print(Q[N][P][R])