import { Model } from 'mongoose';
import { Injectable } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { CaffeineFood, CaffeineFoodDocument } from 'src/schema/CaffeineFoodSchecma';

@Injectable()
export class CaffeineFoodService {
    constructor(@InjectModel(CaffeineFood.name) private caffeineFoodModel: Model<CaffeineFoodDocument>) {}
    
    async searchFood(name: string): Promise<any> {
        try {
          const result = await this.caffeineFoodModel.findOne({ name }).lean();
          return result;
        } catch (err) {
          console.log('error...');
        }
    }

    async addFood(name: string, amount: number): Promise<any> {
        try {
          const result = await this.caffeineFoodModel.create({
            name: name,
            amount: amount,
          });
          return result;
        } catch (err) {
          console.log('Error:', err);
          throw err;
        }
    }

    async allFood(): Promise<any> {
        try {
          const result = await this.caffeineFoodModel.find().exec();
          return result;
        } catch (err) {
          console.log('Error:', err);
          throw err;
        }
    }



}
