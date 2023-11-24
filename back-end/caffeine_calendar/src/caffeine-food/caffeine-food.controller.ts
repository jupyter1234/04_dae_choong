import { Controller, Get, Res, Post, Body, Param } from '@nestjs/common';
import { CaffeineFoodService } from './caffeine-food.service';
import { getCaffeineFoodDto } from 'src/dto/get-caffeineFood.dto'


@Controller('caffeineFood')
export class CaffeineFoodController {
    constructor(private readonly caffeineFoodService: CaffeineFoodService) { }

    @Get()
    findAll(@Res() res) {
	    const caffeineFoods = this.caffeineFoodService.allFood();
        return res.status(200).send(caffeineFoods);
    }

    @Post()
    addCaffeineFood(@Res() res, @Body() getCaffeineFoodDto: getCaffeineFoodDto) {
        const { name, amount } = getCaffeineFoodDto;
        this.caffeineFoodService.addFood(name, amount)
        return res.status(200)
    }
}
