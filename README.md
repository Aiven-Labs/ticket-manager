# ticket-manager

## prerequisites

### Aiven Operator

The Aiven Kuberrnetes Operator needs to be installed, please follow [these instructions](https://aiven.github.io/aiven-operator/installation/prerequisites.html)

### Setting the correct `project` for the CRs

The Aiven's CRs have the project `dev-advocates` hardcoded, make sure you set it to the correct Aiven `project`

## Applying the CRs

### Application and DB

Start by deploying the app and the PostgreSQL provisionning : 

```
kubectl apply -f manifests/app
```

Wait for the `pg-cloudnative` service to be in the state `RUNNING` on the Aiven platform you continue. Also make sure that the db `tickets` has been created

### Kafka, OpenSearch and integration services

Next you can install the rest of the services : 

```
kubectl apply -f manifests/integration
```

Give it some time before everything got reconcialited.

## Accessing the app

A service `ticket-manager` of type `LoadBalancer` has been created for you. 

```
curl -X 'POST' \
  'http://your_host/tickets' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "title": "My Ticket",
  "description": "My description",
  "author": "Sebi",
  "timestamp": "2022-03-10"
}'
```

