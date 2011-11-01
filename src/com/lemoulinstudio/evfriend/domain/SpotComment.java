package com.lemoulinstudio.evfriend.domain;

import java.util.List;

public class SpotComment {
  
  SpotComment parentComment;
  List<SpotComment> children;
  
  String content;
  
}
