package member

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/'
    }
    response {
        status 200
        body("""
  {
    "firstName": "daniel",
    "lastName": "paul"
  }
  """)
        headers {
            header('Content-Type': 'application/json;charset=UTF-8')
        }
    }
}