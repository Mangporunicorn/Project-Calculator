import java.util.Scanner;

class Calculator {
    private final double currentResult;

    public Calculator(double value) {
        this.currentResult = value;
    }

    public Calculator execute(String op, double nextNum) {
        double newResult = currentResult;
        switch (op) {
            case "+": newResult += nextNum; break;
            case "-": newResult -= nextNum; break;
            case "*": newResult *= nextNum; break;
            case "/": 
                if (nextNum != 0) {
                    newResult /= nextNum;
                } else {
                    System.out.println(">>> Error: Division by zero!");
                }
                break;
            case "%": 
                if (nextNum != 0) {
                    newResult %= nextNum;
                } else {
                    System.out.println(">>> Error: Modulo by zero!");
                }
                break;
            default:
                System.out.println(">>> Invalid Operator!");
        }
        return new Calculator(newResult);
    }

    public void display() {
        System.out.printf("[ Current Result: %.2f ]\n", currentResult);     // แสดงผลลัพธ์ .2 ตำแหน่ง
    }

    public double getResult() {
        return currentResult;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("--- Calculator (+ - * / %) ---");
        System.out.print("Enter start number: ");
        double start = kb.nextDouble();               // รับค่าตัวเลขเริ่มต้น
        
        Calculator calc = new Calculator(start);

        while (true) {
            System.out.print("\n(+, -, *, /, %) | 'c' Clear | 'q' Quit: ");
            String op = kb.nextLine();
            
            if (op.equals("q")) break;      // ออกจากโปรแกรม
            
            if (op.equals("c")) {
                System.out.print("Enter new start number: ");
                calc = new Calculator(kb.nextDouble());
                System.out.println("Memory Resetted.");
                continue;
            }

            System.out.print("Next number: ");
            double nextNum = kb.nextDouble();

            calc = calc.execute(op, nextNum);       // อัปเดตผลลัพธื
            calc.display();                         // แสดงผลลัพธ์
        }

        System.out.println("\nFinal result: " + calc.getResult());
        kb.close();
    }
}

