import { Module } from '@nestjs/common';
import { CaffeineFoodController } from './caffeine-food.controller';
import { CaffeineFoodService } from './caffeine-food.service';

@Module({
  controllers: [CaffeineFoodController],
  providers: [CaffeineFoodService]
})
export class CaffeineFoodModule {}
