graph TB
    Developer-->|Push Code|GitHub
    Developer-->|Push Code|AWS_SAM

    subgraph GitHub[GitHub]
        GitHubRepo[GitHub Repository]-->|Trigger|Actions[GitHub Actions]
    end

    GitHub-->|Deploy|VPC
    AWS_SAM[AWS_SAM]-->|Deploy|VPC

    subgraph VPC[AWS VPC]
        subgraph Public[Public Subnet]
            subgraph Gateway[API Gateway]
                Lambda["Lambda (Kotlin+Spring,Node)"]
            end

            EC2["EC2 (Docker + Nginx)"]
            RDS[RDS]

            Lambda-->|2.API Call|EC2
            Lambda-->|3.1.a Request|RDS
            RDS-->|3.2.a Response|Lambda
            EC2-->|4.Response|Lambda
        end
    end

    External[외부 전자 도서관]-->|3.1.b External Request|Lambda
    Lambda-->|3.2.b External Response|External
    
    User-->|1.First Request|EC2
    EC2-->|5.Final Response|User

style VPC fill:#f0f0f0
style Public fill:#fff7e6
style Gateway fill:#e6f3ff
style GitHub fill:#e6ffe6