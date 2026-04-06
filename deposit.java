// Deposit.java
// Representa uma transação de depósito no ATM [cite: 3]

public class Deposit extends Transaction {

    private double amount; // quantia a depositar [cite: 7, 8]
    private Keypad keypad; // referência ao teclado numérico [cite: 10, 11]
    private DepositSlot depositSlot; // referência à abertura para depósito [cite: 13, 14]
    
    // constante para a opção de cancelamento [cite: 16]
    private final static int CANCELED = 0; 

    // Construtor de Deposit [cite: 26]
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, 
                   Keypad atmKeypad, DepositSlot atmDepositSlot) {
        
        // inicializa as variáveis da superclasse [cite: 28]
        super(userAccountNumber, atmScreen, atmBankDatabase); [cite: 29]

        // inicializa as referências a teclado e abertura para depósito [cite: 30]
        this.keypad = atmKeypad; [cite: 30]
        this.depositSlot = atmDepositSlot; [cite: 31]
    } // fim do construtor de Deposit [cite: 33]

    // realiza a transação [cite: 37]
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase(); // obtém a referência [cite: 41]
        Screen screen = getScreen(); // obtém a referência [cite: 43]

        amount = promptForDepositAmount(); // obtém a quantia de depósito do usuário [cite: 45, 47]

        // verifica se usuário inseriu uma quantia de depósito ou cancelou 
        if (amount != CANCELED) {
            // solicita o envelope de depósito contendo a quantia especificada [cite: 58]
            screen.displayMessage("\nPlease insert a deposit envelope containing "); [cite: 58]
            screen.displayDollarAmount(amount); [cite: 59]
            screen.displayMessageLine("."); [cite: 60]

            // verifica se envelope de depósito foi recebido [cite: 78]
            boolean envelopeReceived = depositSlot.isEnvelopeReceived(); [cite: 77]

            if (envelopeReceived) { [cite: 79]
                screen.displayMessageLine("\nYour envelope has been received. \n" +
                    "NOTE: The money just deposited will not be available until we " +
                    "verify the amount of any enclosed cash and your checks clear."); [cite: 80]

                // credita na conta para refletir o depósito [cite: 81]
                bankDatabase.credit(getAccountNumber(), amount); [cite: 82]
            } else { // envelope de depósito não foi recebido [cite: 83]
                screen.displayMessageLine("\nYou did not insert an envelope, " +
                    "so the ATM has canceled your transaction."); [cite: 84]
            } // fim de else [cite: 85]
        } else { // o usuário cancelou em vez de inserir uma quantia [cite: 87, 89]
            screen.displayMessageLine("\nCanceling transaction..."); [cite: 91]
        } // fim de else [cite: 93]
    } // fim do método execute [cite: 104]

    // solicita que o usuário insira uma quantia de depósito em centavos [cite: 105]
    private double promptForDepositAmount() {
        Screen screen = getScreen(); // obtém a referência à tela [cite: 106]

        // exibe a solicitação [cite: 106]
        screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): "); [cite: 107]
        
        int input = keypad.getInput(); // recebe a entrada da quantia do depósito [cite: 107, 108]

        // verifica se o usuário cancelou ou inseriu uma quantia válida [cite: 109]
        if (input == CANCELED) { [cite: 110]
            return CANCELED; [cite: 112]
        } else { [cite: 114]
            return (double) input / 100; // retorna a quantia em dólares [cite: 118]
        } 
    } // fim do método promptForDepositAmount [cite: 119]
} // fim da classe Deposit [cite: 120]