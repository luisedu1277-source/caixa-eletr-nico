// BalanceInquiry.java
// Representa uma transação de consulta de saldos no ATM

public class BalanceInquiry extends Transaction {

   // Construtor de BalanceInquiry
   public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
      super(userAccountNumber, atmScreen, atmBankDatabase);
   } // fim do construtor de BalanceInquiry

   @Override
   public void execute() {
      // obtém as referências ao banco de dados e tela do banco
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // obtém o saldo disponível da conta envolvida
      double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

      // obtém o saldo total da conta envolvida
      double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

      // exibe as informações sobre o saldo na tela
      screen.displayMessageLine("\nBalance Information: ");
      screen.displayMessage(" - Available balance: ");
      screen.displayDollarAmount(availableBalance);
      screen.displayMessage("\n - Total balance....: ");
      screen.displayDollarAmount(totalBalance);
      screen.displayMessageLine("");
   } // fim do método execute
} // fim da classe BalanceInquiry