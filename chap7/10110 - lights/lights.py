import fileinput
cuadrados = [i**2 for i in range(1, 2**16)]

def busqueda(value):
	first = 0
	last = len(cuadrados)-1
	found = False
	while first<=last and not found:
		midpoint = (first + last)//2
		if value == cuadrados[midpoint]:        
			found =  True 
		else:
			if value < cuadrados[midpoint]:
				last = midpoint-1
			else:
				if value > midpoint:
					first = midpoint+1  
	return found

if __name__ == '__main__':
	lines = fileinput.input()
	for line in lines:
		if int(line) == 0: break
		if busqueda(int(line)): print('yes')
		else: print('no')
