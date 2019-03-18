package com.spring.aop.pointcut.advisor.composable.service;

public class AnminalService {
    private HorseService horseService;
    private TigerService tigerService;


    /**
     * @param horseService
     * @param tigerService
     */
    public AnminalService(HorseService horseService,
                          TigerService tigerService) {
        this.horseService = horseService;
        this.tigerService = tigerService;

    }

    /**
     * 流程切面的演示
     */
    public void eat() {
        horseService.eat();
        tigerService.eat();
    }
}
