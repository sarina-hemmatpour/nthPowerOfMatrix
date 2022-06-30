package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {

        int size , n;

        System.out.println("Enter size of your matrix: ");
        size=input.nextInt();

        System.out.println("Enter n:");
        n=input.nextInt();

        float[][] A=new float[size][size];

        //fill
        fillMatrix(A,size);

        float[][] result=new float[size][size];

        if (n==1)
        {
            printMatrix(A , size);
        }
        if (n>1)
        {
            for (int i=0 ; i<size ; i++)
            {
                for (int j=0 ; j<size ; j++)
                {
                    result[i][j]=A[i][j];
                }
            }

            for (int i=2 ; i<=n ; i++)
            {
                result=multiply(result , A , size);
            }

            printMatrix(result , size);
        }


        
    }

    public static void fillMatrix(float[][] matrix , int size)
    {
        for (int i=0 ; i<size ; i++)
        {
            System.out.println("Enter line " + i + ":");
            for (int j=0 ; j<size ; j++)
            {
                matrix[i][j]=input.nextFloat();
            }
            input.nextLine();
        }

        System.out.println("Done!");
    }

    public static float[][] multiply(float[][] first , float[][] sec , int size )
    {
        float[][] result=new float[size][size];

        int i=0 , radif=0;
        for ( ; radif<size ; radif++ , i++ )
        {
            int sotun=0 , jp=0;
            for ( ; sotun<size ; sotun++, jp++)
            {
                int element=0;

                int j=0;
                for (int ip=0 ; ip<size ; j++,ip++)
                {
                    element+=first[i][j]*sec[ip][jp];
                }

                result[radif][sotun]=element;
            }
        }

        return result;
    }

    public static void printMatrix(float[][] matrix , int size)
    {
        for (int i=0 ; i<size ; i++)
        {
            for (int j=0 ; j<size ; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
