#include<iostream>
using namespace std;
long long int solution(long long int,long long int);
int main(){
    unsigned long long int test ;
    cin>>test;
    while(test--){
        long long int num;
        cin>>num;
        long long int k ;
        cin>>k;
        long long int result = solution(num,k);
        cout<<result<<endl;
    }
}
long long int solution(long long num,long long k){
    long long int mod = 1000000007;
        if(num >= k)
            return k-1;
    long long int a = k;
    long long int d = num-1;
    long long int r = (a-2)%(d);
    long long int second = 1 + (a-2)/d;
    long long int first = (a + r);
    return (first*second/2)%mod;
}