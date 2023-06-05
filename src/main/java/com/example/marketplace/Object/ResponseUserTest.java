package com.example.marketplace.Object;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ResponseUserTest")
@Getter
@Setter
public class ResponseUserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "response_options_id")
    private Long responseOptionsId;

    // добавляем свойство responseOptions c аннотацией @OneToOne
    // и ссылкой на объект ResponseOptions по идентификатору responseOptionsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_options_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ResponseOptions responseOptions;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Tests tests;



}
