package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculatorrequest.CalculatorAddRequest;
import com.group.libraryapp.dto.calculatorrequest.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // API 진입 지점 설정 어노테이션
public class CalculatorController {
    //API 명세
    // HTTP Method : Get
    // HTTP Path : /add
    // 쿼리(Key & value) : int number1, int number2
    // API 반환 결과 : 두 숫자의 덧셈결과

/*    @GetMapping("/add") // HttpMethod Path
    public int addTwoNumbers(
            @RequestParam int num1,  // @RequestParam 주어지는 쿼리를 함수 파라미터에 넣는다
            @RequestParam int num2
    ) {
        return num1 + num2;
    }*/

    @GetMapping("/add") // HttpMethod Path
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNum1() + request.getNum2();
    }

    //API 명세
    // HTTP Method : POST
    // HTTP Path : /multiply
    // 쿼리(Key & value) : int number1, int number2
    // API 반환 결과 : 두 숫자의  곱셈결과
    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest req){
        return req.getNum1() * req.getNum2();
    }
}
