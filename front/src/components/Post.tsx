import React from 'react'
import { PostsQuery } from '../generated/graphql'

export const PostComponent = ({ post } : {post: PostsQuery["posts"][number]}) => (
  <div>
    <div>
      {post.title} ({post.category})
    </div>
  </div>
)
