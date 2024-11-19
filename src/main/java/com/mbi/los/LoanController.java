package com.mbi.los;

import java.util.ArrayList;
import java.util.List;

import com.mbi.los.dao.*;

public class LoanController {
    private List<LoanApplication> loanApplications;
    private LoanService loanService;

    public LoanController() {
        loanApplications = new ArrayList<>();
        loanService = new LoanService();
    }

    // Method to submit a new loan application
    public void submitLoanApplication(LoanApplication application) {
        loanApplications.add(application);
    }

    // Method to process all pending loan applications
    public void processLoanApplications() {
        for (LoanApplication application : loanApplications) {
            if (!application.isProcessed()) {
                loanService.submitLoanApplication(application);
            }
        }
    }

    // Method to retrieve a list of all processed loan applications
    public List<LoanApplication> getProcessedLoanApplications() {
        List<LoanApplication> processedApplications = new ArrayList<>();
        for (LoanApplication application : loanApplications) {
            if (application.isProcessed()) {
                processedApplications.add(application);
            }
        }
        return processedApplications;
    }
}
