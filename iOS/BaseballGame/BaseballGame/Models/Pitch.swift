//
//  Pitch.swift
//  BaseballGame
//
//  Created by delma on 2020/05/13.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

struct Pitch: Codable {
    var result: NowPlayInfo
    var inningTotal: InningTotal
    var game: GameInfo
}

struct NowPlayInfo: Codable {
    var pitcher: Pitcher
    var hitter: Hitter
    var inning: Int
    var turn: String
    var pitchResult: String
    var out: Bool
}

struct Pitcher: Codable {
    var name: String
    var pitchCount: Int
}

struct Hitter: Codable {
    var name: String
    var order: Int
    var batCount: Int
    var hitCount: Int
}

struct InningTotal: Codable {
    var ball: Int
    var strike: Int
    var out: Int
    var base: Int
}
