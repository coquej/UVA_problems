import fileinput, math

def hacer(n,m):

    count = 0
    M = m

    for i in range(2, math.ceil(math.sqrt(m))+1):
        while m%i == 0:
            m /= i
            count +=1
        if count > 0:
            j = i
            while j <= n:
                count -= n / j
                j *= i
            if count > 0:
                return str(M) + " does not divide " + str(n) + "!"
        count = 0

    if m<=n: return str(M) + " divides " + str(n) + "!"
    else: return str(M) + " does not divide " + str(n) + "!"


if __name__ == "__main__":
    lines=fileinput.input()

    for line in lines:
        n,m = map(int, line.split())
        print(hacer(n,m))