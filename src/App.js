import './App.css';
import React, { useState, useEffect } from 'react'



function App() {

  const [purchaseData, setPurchaseData] = useState();
  const [customerData, setCustomerData] = useState();
  const purchaseUrl = "http://localhost:8080/api/purchases"
  const customerUrl = "http://localhost:8080/api/v1/customers"

  const fetchPurchaseData = async () => {
    const pData = await fetch(purchaseUrl)
    .then((result) => {return result.json()})
    .then((data) => {
      setPurchaseData(data)
    })
    return pData
  }
  const fetchCustomerData = async () => {
    const cData = await fetch(customerUrl)
    .then((result) => {return result.json()})
    .then((data) => {
      setCustomerData(data)
    })
    return cData
  }

  const rewardCalc = (number) => {
    let flooredNum = Math.floor(number)
    let total = 0;
    if(flooredNum < 51){
      return total;
    }
    if(flooredNum >= 51 && flooredNum < 100){
      total = flooredNum - 50;
    }
    if(flooredNum >= 101){
      total = (flooredNum - 100)*2 + 50;
    }
    return total
  }

  useEffect(() => {
    fetchCustomerData()
    fetchPurchaseData()
    
  },[])
  // console.log(customerData)
  return (
    <main className='App'>
        {customerData?.map((customer) => (
          <div  key={customer.id}>
             <h4>{customer.firstName+" "+customer.lastName}</h4>
            <table >
              <thead>
              <tr>
                <th>Purchase Date</th>
                <th>Purchase Amount</th>
                <th>Reward</th>
              </tr>
              </thead>
              {purchaseData?.filter((purchase) => purchase.customer === customer.id).map((purchase) => (
                <tbody key={purchase.id}>
                  <tr>
                    <td>{purchase.purchaseDate.slice(0,10)}</td>
                    <td >${purchase.amount}</td>
                    <td>{rewardCalc(purchase.amount)}pt</td>
                  </tr>
                </tbody>
              ))}
              <tfoot>
                <tr>
                  <td>Total:{purchaseData?.filter((purchase) => purchase.customer === customer.id).reduce((a, b) =>{
                  console.log(a?.amount)
                  return rewardCalc(a?.amount) + rewardCalc(b.amount)}
                    
                    )}</td>
                </tr>
              </tfoot>
            </table>
          </div>
        ))}
    </main>
  );
}

export default App;

