public class VietChuongTrinhNguyenTo{
    static void displayArray(ArrayList<Integer> array)
    {
        // Here is code
    }
    static void displayNegativeNumber(ArrayList<Integer> array)
    {
        System.out.print('Negative number in array');
        for (int num: array)
        {
            if (num <=1)
                System.out.print(num + ' ');
        }
        System.out.print();
    }
    static boolean isPrime(int num)
    {
        if (num <=1)
            return false;
        for (int i =2; i*i <= num; i++){
            if (num % i ==0)
                return false;
        }
        return true;
    }
    static void displayPrimeNumber(ArrayList<Integer> array)
    {
        System.out.print('Prime number in array');
        for (int num: array)
        {
            System.out.print(num + ' ');
        }
        System.out.print();
    }
    static void displayElementsInRange(ArrayList<Integer> array, Scanner scanner)
    {
        System.out.print('Enter the a value: ');
        int a = scanner.nextInt();
        System.out.print('Enter the b value: ');
        int b = scanner.nextInt();
        System.out.print('Cac phan tu co gia tri trong doan ' + '['+ a +','+ b + ']');
        for (int num: array)
        {
            if (num >=a && num <=b)
            {
                System.out.print(num + ' ');
            }
        }
        System.out.print();
    }
}
