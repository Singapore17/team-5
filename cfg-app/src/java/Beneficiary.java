import java.sql.Date;

public class Beneficiary {

    private String id;
    private String category;
    private Date last_receipt;
    private int headcount;
    private int request_counter;
    private int receipt_counter;

    public Beneficiary(
            String id,
            String category,
            Date last_receipt,
            int headcount,
            int request_counter,
            int receipt_counter
    ) {
        this.setId(id);
        this.setCategory(category);
        this.setLast_receipt(last_receipt);
        this.setHeadcount(headcount);
        this.setRequest_counter(request_counter);
        this.setReceipt_counter(receipt_counter);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getLast_receipt() {
        return last_receipt;
    }

    public void setLast_receipt(Date last_receipt) {
        this.last_receipt = last_receipt;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public int getRequest_counter() {
        return request_counter;
    }

    public void setRequest_counter(int request_counter) {
        this.request_counter = request_counter;
    }

    public int getReceipt_counter() {
        return receipt_counter;
    }

    public void setReceipt_counter(int receipt_counter) {
        this.receipt_counter = receipt_counter;
    }

}
