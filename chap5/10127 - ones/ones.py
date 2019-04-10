import fileinput


def hacer(n):
	x = 1
	counter = 1
	while True:
		if x%n == 0: break
		x = x*10 + 1
		x %= n
		counter+=1
	return counter


if __name__ == "__main__":
	lines = fileinput.input()
	for line in lines:
		print(hacer(int(line)))