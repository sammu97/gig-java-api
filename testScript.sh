#!/bin/bash
printf "Initializing Docker Containers...\n"
docker-compose up -d --build
printf "All Docker containers are running!\n\n"

until [ "$(curl -w '%{response_code}' --no-keepalive -o /dev/null --connect-timeout 1 localhost:8080/heartbeat)" == "200" ];
do echo --- sleeping for 1 second;
sleep 1;
done

printf "Web application has started! Beginning Test...\n\n"

printf "Adding Account '0000001' with an amount of €20000\n"
addResponse1=$(curl -s --header "Content-Type: application/json" --request POST --data '{"balance": "20000","accountNumber": "0000001"}' localhost:8080/api/account/addOrUpdate)

printf "\nAdding Account '0000002' with an amount of €10000\n"
addRespons2=$(curl -s --header "Content-Type: application/json" --request POST --data '{"balance": "10000","accountNumber": "0000002"}' localhost:8080/api/account/addOrUpdate)

printf "\nGetting list of accounts within database now...\n"
curl --request GET localhost:8080/api/account/getAll
printf "\n"

printf "\nMaking a bank transfer of €10000 from Account '0000002' to Account '0000001'\n"
curl -s --header "Content-Type: application/json" \
  --request POST \
  --data '{"sender": "0000002","receiver": "0000001","amount": "10000"}' \
  localhost:8080/api/account/bankTransfer
printf "Transfer completed!\n\n"

printf "Retrieving Balance for Account Number '0000001'\n"
balance_0000001=$(curl -s --request GET localhost:8080/api/account/balanceByAccountNo/0000001)
printf "Balance for Account Number '0000001' is €%s\n" $balance_0000001

if [ "$balance_0000001" == 30000.0 ]
then
    printf "Balance is correct!\n\n"
else
    printf "Balance is incorrect! Test failed!\n\n"
    exit 0
fi

printf "Retrieving Balance for Account Number '0000002'\n"
balance_0000002=$(curl -s --request GET localhost:8080/api/account/balanceByAccountNo/0000002)
printf "Balance for Account Number '0000002' is €%s\n" $balance_0000002

if [ "$balance_0000002" == 0.0 ]
then
    printf "Balance is correct!\n\n"
else
    printf "Balance is incorrect! Test failed!\n\n"
    exit 0
fi

printf "\nTests completed! Stopping container...\n"
docker stop gig-java-api-container
docker stop java-api-mysql

docker rm gig-java-api-container
docker rm java-api-mysql





