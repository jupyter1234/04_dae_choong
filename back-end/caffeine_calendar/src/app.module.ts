import { Module, NestModule } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { UserModule } from './user/user.module';
import { CalendarModule } from './calendar/calendar.module';
import { CaffeineFoodModule } from './caffeine-food/caffeine-food.module';
import { YoutubeModule } from './youtube/youtube.module';
import { MongooseModule } from '@nestjs/mongoose';
import { ConfigModule } from '@nestjs/config';
import mongoose from 'mongoose';
import { CaffeineFood, CaffeineFoodSchema } from './schema/CaffeineFoodSchecma';
/*eslint-disabled*/
@Module({
  imports: [
    ConfigModule.forRoot(),
    MongooseModule.forRoot(process.env.MongoDB_URI),
    MongooseModule.forFeature([{ name: CaffeineFood.name, schema: CaffeineFoodSchema }]),
    UserModule,
    CalendarModule,
    CaffeineFoodModule,
    YoutubeModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule implements NestModule {
  private readonly isDev: boolean = process.env.MODE === 'dev' ? true : false;
  configure() {
    mongoose.set('debug', this.isDev);
    console.log('연결완료');
  }
}
