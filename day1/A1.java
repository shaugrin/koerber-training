class A1{
    public static void main(String args[]){
        int a=1;
        int b=1;
        int c;
        int i=0;
        int sum=0;
        while(i<20){
            System.out.print(a+" ");
            sum+=a;
            c=a+b;
            a=b;
            b=c;
            i++;
        }

        System.out.println("\naverage: "+ sum/20);
    }
}