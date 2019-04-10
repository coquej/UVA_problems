import fileinput as fi
import math as m


if __name__ == "__main__":
	lines_i = fi.input()
	lines = [line.strip() for line in lines_i]

	for i in range(1,int(lines[0])+1):
		line = lines[i].split()
		n = m.fabs(float(line[0])-float(line[1]))
		x = m.ceil((m.sqrt(4*n))-1)
		if x<0: 
			print(0)
		else:
			print(x)