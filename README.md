# Payment Point Automation Test

## Prerequisites
This project requires the following dependencies:
* openjdk 19.0.2 (you can use sdkman to have multiple versions of java)
* Apache Maven 3.9.0 (can be installed using sdkman)
 
## Running the Project

### Run with maven

1. make sure you have maven installed
2. copy xlsx file from docs to src/test/resources
3. run test with this command

   ```bash
   mvn verify
   ```

### Run with specific data provider file

If you want to specify custom path for data provider file

```bash
mvn verify -Ddataprovider=<path to xlsx file>
```

for example:

```bash
mvn verify -Ddataprovider=payment-point-automation.xlsx
```

Run specify test you can use

```bash
mvn clean verify -Dit.test=CreatePaymentTest,CancelPaymentTest
```

Run specify namespace test you can use

```bash
mvn clean verify -Dit.test="id.co.algo.ppobtest.plnpostpaid.**"
```

Run specify namespace test with specify data provider you can use

```bash
mvn clean verify -Dit.test="id.co.algo.ppobtest.plnpostpaid.**" -Ddataprovider="src/test/resources/ppob-plnpostpaid-automation.xlsx"
```

#### Sample Report:

![Specifications](docs/ss-1.png)

![Test Results](docs/ss-2.png)

![Scenario](docs/ss-3.png)