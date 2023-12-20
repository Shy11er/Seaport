package com.example.Seaport.dto;

public class AccountingDto {
    private Long amountOfRequests;
    private Long amountFine;
    private Double averQueue;
    private Double duration;
    private Long maxDur;

    public AccountingDto(Long amountOfRequests, Long amountFine, Double averQueue, Double duration, Long maxDur) {
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

    public Long getAmountFine() {
        return amountFine;
    }

    public Long getAmountOfRequests() {
        return amountOfRequests;
    }

    public Long getMaxDur() {
        return maxDur;
    }

    public void setAmountFine(Long amountFine) {
        this.amountFine = amountFine;
    }

    public void setAmountOfRequests(Long amountOfRequests) {
        this.amountOfRequests = amountOfRequests;
    }

    public void setAverQueue(Double averQueue) {
        this.averQueue = averQueue;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setMaxDur(Long maxDur) {
        this.maxDur = maxDur;
    }
}
