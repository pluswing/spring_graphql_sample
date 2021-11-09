import React from 'react'
import { Post } from '../generated/graphql'

export const PostComponent = ({ post } : {post: Post}) => (
  <div>
    <div>
      {post.title} ({post.category})
    </div>
  </div>
)
