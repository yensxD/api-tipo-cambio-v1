package domain.model;

import java.math.BigDecimal;

public class ExchangeRate {
    private String date;
    private BigDecimal buy;
    private BigDecimal sell;

    public ExchangeRate() {
    }

    public ExchangeRate(String date, BigDecimal buy, BigDecimal sell) {
        this.date = date;
        this.buy = buy;
        this.sell = sell;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }
}
