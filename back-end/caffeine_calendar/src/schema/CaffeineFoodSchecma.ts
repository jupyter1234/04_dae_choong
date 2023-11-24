import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document } from 'mongoose';

export type CaffeineFoodDocument = CaffeineFood & Document;

@Schema()
export class CaffeineFood {
  @Prop()
  name: string;

  @Prop()
  amount: number;

}

export const CaffeineFoodSchema = SchemaFactory.createForClass(CaffeineFood);