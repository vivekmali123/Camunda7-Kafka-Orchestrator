package com.mbi.los;

//LoanService.java

import org.springframework.stereotype.Service;


import com.mbi.los.dao.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    private List<LoanApplication> loanApplications;

    public LoanService() {
        loanApplications = new ArrayList<>();
    }

    public void submitLoanApplication(LoanApplication application) {
        loanApplications.add(application);
    }

    public void processLoanApplications() {
        for (LoanApplication application : loanApplications) {
            if (!application.isProcessed()) {
                // Perform processing logic here
                application.setProcessed(true);
            }
        }
    }

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

