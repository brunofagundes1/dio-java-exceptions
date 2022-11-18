import javax.swing.JOptionPane;

public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            try {
                double resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                // e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entre com um número\n" + e.getMessage());
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, "Denominador não pode ser 0");
            } finally {
                System.out.println("Finally");
            }
        } while (continueLooping == true);

        System.out.println("Final");

    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}
