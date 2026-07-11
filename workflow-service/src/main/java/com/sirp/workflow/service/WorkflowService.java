package com.sirp.workflow.service;

import com.sirp.workflow.dto.request.CreateWorkflowRequest;
import com.sirp.workflow.dto.response.WorkflowResponse;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkflowService {

    WorkflowResponse createWorkflow(CreateWorkflowRequest request);

    WorkflowResponse getWorkflowById(UUID workflowId);

    WorkflowResponse getWorkflowByIncidentId(UUID incidentId);

    Page<WorkflowResponse> getAllWorkflows(Pageable pageable);

    List<WorkflowResponse> getWorkflowsByAssignedUser(UUID userId);

    List<WorkflowResponse> getWorkflowsByAssignedTeam(UUID teamId);

    void deleteWorkflow(UUID workflowId);
}