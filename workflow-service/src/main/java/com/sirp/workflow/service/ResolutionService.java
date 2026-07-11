package com.sirp.workflow.service;

import com.sirp.workflow.dto.request.CloseWorkflowRequest;
import com.sirp.workflow.dto.request.ResolveWorkflowRequest;
import com.sirp.workflow.dto.response.WorkflowResponse;
import java.util.UUID;

public interface ResolutionService {

    WorkflowResponse resolveWorkflow(UUID workflowId, ResolveWorkflowRequest request);

    WorkflowResponse closeWorkflow(UUID workflowId, CloseWorkflowRequest request);

}