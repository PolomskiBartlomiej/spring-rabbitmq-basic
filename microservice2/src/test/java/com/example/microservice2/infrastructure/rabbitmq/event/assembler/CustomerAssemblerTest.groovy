package com.example.microservice2.infrastructure.rabbitmq.event.assembler

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.infrastructure.rabbitmq.event.CustomerCreate
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerAssemblerTest extends Specification {
    def "test toEntity"() {
        given:
        def customerCreate = CustomerCreate.builder()
                .id(1)
                .firstName("firstName")
                .build()

        and:
        def expectedCustomer = Customer.builder()
                .id(1)
                .firstName("firstName")
                .build()

        expect:
        expectedCustomer == CustomerAssembler.toEntity(customerCreate)
    }
}
