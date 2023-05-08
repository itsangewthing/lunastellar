import { Card } from "./card.model";

export interface Reading {
    readingId: string;
    cards: Card[];
    readingDate: string;
}