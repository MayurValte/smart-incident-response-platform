package com.sirp.workflow.service;

import com.sirp.workflow.dto.request.AssignWorkflowRequest;
import com.sirp.workflow.dto.response.WorkflowResponse;
import java.util.UUID;

public interface AssignmentService {

    WorkflowResponse assignWorkflow(UUID workflowId, AssignWorkflowRequest request, UUID actorId);

    WorkflowResponse reassignWorkflow(UUID workflowId, AssignWorkflowRequest request, UUID actorId);
}