#include <iostream>
#include <string>

struct elephant{
    int index;
    int w;
    int s;
};

void rp(elephant *e, int *pred, int i){
    if(i>=0 && pred[i]>=0){
        rp(e,pred,pred[i]);
    }
    printf("%d\n",e[i].index+1);
}

int main(){

    struct elephant e [10000];
    int n=0,w,s;

    // Aqui leer lineas y meterlas en el
    while(scanf("%d %d", &w,&s) != EOF){
        elephant a;
        a.w=w;
        a.s=s;
        a.index=n;
        e[n]=a;
        n++;
    }

    // Ordenar lista de elefantes
    for(int i=0; i< n-1; ++i)
     {
         for(int j=i+1; j < n; j++)
         { 
            if( e[i].w == e[j].w && e[i].s < e[j].s){
                 struct elephant temp = e[i] ;
                 e[i] = e[j] ;
                 e[j] = temp ;
             
             }
             else if( e[i].w > e[j].w ) 
             {
                 struct elephant temp = e[i] ;
                 e[i] = e[j] ;
                 e[j] = temp ;
             }
         }
     }

    int dp[n], pred[n];
    for (int i = 0; i < n; ++i){ dp[i]=1; pred[i]=-1; }
    
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++ )
            if( e[i].w < e[j].w && e[i].s > e[j].s)
                if(dp[i]+1 >= dp[j]){
                    dp[j]=dp[i]+1; pred[j]=i;
                }
            
    

    int lmax=1;
    int pos=0;
    for (int i= pos+1; i<n; i++){
        if(dp[i]>lmax){
            lmax=dp[i];
            pos=i;
        }
    }
    printf("%d\n",lmax);

    rp(e,pred,pos);

    return 0;
}







