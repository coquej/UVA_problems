#include <iostream>
#include <cstdio>
#include <cstdlib>
#define N 65000

bool carmichael[N];

int main (){

	for (int i = 0; i < N; i++) {
		carmichael[i] = false;
	}

	carmichael[561] = true;
	carmichael[1105] = true;
	carmichael[1729] = true;
	carmichael[2465] = true;
	carmichael[2821] = true;
	carmichael[6601] = true;
	carmichael[8911] = true;
	carmichael[10585] = true;
	carmichael[15841] = true;
	carmichael[29341] = true;
	carmichael[41041] = true;
	carmichael[46657] = true;
	carmichael[52633] = true;
	carmichael[62745] = true;
	carmichael[63973] = true;



	int numero;
	while(scanf("%d", &numero)){

		if(numero == 0) break;
		if(!carmichael[numero]) printf("%d is normal.\n", numero);
		else printf("The number %d is a Carmichael number.\n", numero);
	}

}