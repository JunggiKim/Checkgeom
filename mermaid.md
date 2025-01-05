%%% System Architecture Diagram
%%% Main components and their relationships

%%% Define main actors and deployment
graph TB
    Developer-->|Push Code|GitHub
    Developer-->|Push Code|AWS_SAM

%%% GitHub Section
    subgraph GitHub[GitHub]
        GitHubRepo[GitHub Repository]-->|Trigger|Actions[GitHub Actions]
    end

%%% Deployment flows
    GitHub-->|Deploy|VPC
    AWS_SAM[AWS_SAM]-->|Deploy|VPC

%%% AWS VPC Infrastructure
    subgraph VPC[AWS VPC]
        subgraph Public[Public Subnet]
            %%% API Gateway and Lambda
            subgraph Gateway[API Gateway]
                Lambda["Lambda (Kotlin+Spring,Node)"]
            end
            
            %%% Core Services
            EC2["EC2 (Docker + Nginx)"]
            RDS[RDS]
            
            %%% Internal Request Flow
            EC2-->|2.API Call|Lambda
            Lambda-->|3.1.a Request|RDS
            RDS-->|3.2.a Response|Lambda
            Lambda-->|4.Response|EC2
        end
    end

%%% External System
    External[외부 전자 도서관]
    Lambda-->|3.1.b External Request|External
    External-->|3.2.b External Response|Lambda

%%% User Flow
    User-->|1.First Request|EC2
    EC2-->|5.Final Response|User

%%% Styling
style VPC fill:#f0f0f0
style Public fill:#fff7e6
style Gateway fill:#e6f3ff
style GitHub fill:#e6ffe6