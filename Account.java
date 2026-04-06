// Account.java
// Representa uma conta bancária

public class Account {
   private int accountNumber;          // número da conta
   private int pin;                    // PIN para autenticação
   private double availableBalance;    // fundos disponíveis para saque
   private double totalBalance;        // fundos disponíveis + depósitos pendentes

   // O construtor Account inicializa os atributos
   public Account(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   } // fim do construtor Account

   // determina se um PIN especificado pelo usuário corresponde ao PIN em Account
   public boolean validatePIN(int userPIN) {
      if (userPIN == pin)
         return true;
      else
         return false;
   } // fim do método validatePIN

   // retorna o saldo disponível
   public double getAvailableBalance() {
      return availableBalance;
   } // fim de getAvailableBalance

   // retorna o saldo total
   public double getTotalBalance() {
      return totalBalance;
   } // fim do método getTotalBalance

} // fim da classe Account