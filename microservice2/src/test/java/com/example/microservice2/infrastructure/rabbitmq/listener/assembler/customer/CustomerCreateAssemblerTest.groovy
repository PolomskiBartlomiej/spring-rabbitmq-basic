package com.example.microservice2.infrastructure.rabbitmq.listener.assembler.customer

import com.example.microservice2.domain.customer.model.Customer
import com.example.microservice2.infrastructure.rabbitmq.event.customer.CustomerCreate
import com.example.microservice2.infrastructure.rabbitmq.listener.assembler.customer.CustomerCreateAssembler
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2018-07-20.
 */
class CustomerCreateAssemblerTest extends Specification {
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
        expectedCustomer == CustomerCreateAssembler.toEntity(customerCreate)
    }
}