package ATMLLD.chainofresposibility;

public abstract class NoteDispenser implements DispenseChain {

    private DispenseChain dispenseChain;
    private int numOfNotes;
    private int noteValue;

    public NoteDispenser(int numOfNotes, int noteValue) {
        this.numOfNotes = numOfNotes;
        this.noteValue = noteValue;
    }

    public void setNextChain(DispenseChain chain) {
        this.dispenseChain = chain;
    }

    public void dispenseCash(int amount) {
        if (amount >= noteValue) {
            int noteUsed = Math.min(amount / noteValue, numOfNotes);
            int rem = amount - (noteValue * noteUsed);
            
            numOfNotes -= noteUsed;

            System.out.println("Dispensing "+ noteUsed + "*"+ noteValue + " notes");

            if(rem > 0 && dispenseChain != null){
                dispenseChain.dispenseCash(rem);
            }
            return;
        } else if (dispenseChain != null) {
            this.dispenseChain.dispenseCash(amount);
            return;
        }
    }

    public boolean canDispense(int amount) {
        if (amount < 0)
            return false;
        if (amount == 0)
            return true;

        int noteUsed = Math.min(amount / noteValue, numOfNotes);
        int rem = amount - (noteValue * noteUsed);

        if (rem == 0)
            return true;
        if (rem > 0 && dispenseChain != null) {
            return dispenseChain.canDispense(rem);
        }
        return false;
    }
}
