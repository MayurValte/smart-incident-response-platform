package com.sirp.workflow.service;

import com.sirp.workflow.dto.request.EscalateWorkflowRequest;
import com.sirp.workflow.dto.response.WorkflowResponse;
import java.util.UUID;

public interface EscalationService {

    WorkflowResponse escalateWorkflow(UUID workflowId, EscalateWorkflowRequest request);

    void processScheduledEscalations();

}