package at.fhv.td.dto;

public class TicketDTO {
    private int _ticketNumber;
    private String _categoryname;
    private String _client;
    private Float _price;
    private Long _id;

    public TicketDTO(int ticketNumber, String categoryname, String client, Float price, Long id) {
        _ticketNumber = ticketNumber;
        _categoryname = categoryname;
        _client = client;
        _price = price;
        _id = id;
    }

    public int getTicketNumber() {
        return _ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        _ticketNumber = ticketNumber;
    }

    public String getCategoryname() {
        return _categoryname;
    }

    public void setCategoryname(String categoryname) {
        _categoryname = categoryname;
    }

    public String getClient() {
        return _client;
    }

    public void setClient(String client) {
        _client = client;
    }

    public Float getPrice() {
        return _price;
    }

    public void setPrice(Float price) {
        _price = price;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
}
