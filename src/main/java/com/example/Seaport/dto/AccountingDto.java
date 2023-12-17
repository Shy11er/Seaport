package com.example.Seaport.dto;

public class AccountingDto {
    private Integer amountOfRequests;
    private Integer amountFine;
    private Double averQueue;
    private Double duration;
    private Integer maxDur;

    public AccountingDto(Integer amountOfRequests, Integer amountFine, Double averQueue, Double duration, Integer maxDur) {
        this.amountOfRequests = amountOfRequests;
        this.amountFine = amountFine;
        this.averQueue = averQueue;
        this.duration = duration;
        this.maxDur = maxDur;
    }

    public AccountingDto(){}

    public Double getAverQueue() {
        return averQueue;
    }

    public Double getDuration() {
        return duration;
    }

    public Integer getAmountFine() {
        return amountFine;
    }

    public Integer getAmountOfRequests() {
        return amountOfRequests;
    }

    public Integer getMaxDur() {
        return maxDur;
    }

    public void setAmountFine(Integer amountFine) {
        this.amountFine = amountFine;
    }

    public void setAmountOfRequests(Integer amountOfRequests) {
        this.amountOfRequests = amountOfRequests;
    }

    public void setAverQueue(Double averQueue) {
        this.averQueue = averQueue;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setMaxDur(Integer maxDur) {
        this.maxDur = maxDur;
    }
}
